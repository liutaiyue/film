package cn.tarena.film.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tarena.film.pojo.Film;
import cn.tarena.film.pojo.Order;
import cn.tarena.film.pojo.User;
import cn.tarena.film.service.FilmService;
import cn.tarena.film.service.OrderService;
import cn.tarena.film.service.UserService;
import cn.tarena.film.tool.StyleUtil;

@Controller
@RequestMapping("/back/")
public class PrintController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private OrderService orderService;
	// 报表打印
	@RequestMapping("printUser")
	public String printUser() throws IOException {

		// 准备打印数据
		List<User> userList = userService.findAll();

		/**
		 * 1.创建工作空间 2.创建工作簿 3.创建行 4.创建单元格
		 * 
		 */
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("用户信息表");
		// 设定列宽
		for (int i = 0; i < 12; i++) {
			sheet.setColumnWidth(i, 13 * 256);
		}

		sheet.setColumnWidth(11, 40 * 256);

		Row titleRow = sheet.createRow(0); // 创建标题行
		titleRow.setHeightInPoints(48);
		; // 设定行高为48

		Cell cell = titleRow.createCell(0);
		cell.setCellValue("用户信息表");

		// 设置合并单元格 起始行 结束行 起始列 结束列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));

		// 设定标题样式
		CellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setAlignment(HorizontalAlignment.CENTER); // 设定水平居中
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 设定垂直居中

		// 设定标题样式
		Font titleFont = workbook.createFont();
		titleFont.setFontName("黑体");
		titleFont.setFontHeightInPoints((short) 28);
		titleFont.setBold(true); // 标题元素加粗
		titleStyle.setFont(titleFont); // 将字体格式添加到样式中
		cell.setCellStyle(titleStyle);

		// 设定副标题
		int subCols = 0; // 设定行号
		Row subTitle = sheet.createRow(1); // 创建第二行
		subTitle.setHeightInPoints(35);
		String[] clos = { "用户ID", "用户名" };
		Font subFont = workbook.createFont();
		subFont.setFontName("黑体");
		subFont.setFontHeightInPoints((short) 12); // 字体12号
		subFont.setBold(true);
		CellStyle subStyle = workbook.createCellStyle(); // 设定单元格字体
		subStyle.setFont(subFont);
		subStyle.setAlignment(HorizontalAlignment.CENTER); // 左右居中
		subStyle.setVerticalAlignment(VerticalAlignment.CENTER); // 上下居中
		subStyle.setBorderBottom(BorderStyle.THIN); // 下细线
		subStyle.setBorderTop(BorderStyle.THIN); // 上细线
		subStyle.setBorderLeft(BorderStyle.THIN); // 左细线
		subStyle.setBorderRight(BorderStyle.THIN); // 右细线

		for (String titleName : clos) {
			Cell subCell = subTitle.createCell(subCols++); // 循环新增行
			subCell.setCellValue(titleName);
			subCell.setCellStyle(subStyle);
		}

		// 定义打印数据

		int uRow = 2; // 表示第三行
		CellStyle dCellStyle = workbook.createCellStyle();
		dCellStyle = StyleUtil.borderThinAndCenter(dCellStyle);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		for (User user : userList) {
			int uCol = 0;
			Row userRow = sheet.createRow(uRow++); // 行自增 一行12列
			Cell dataCell = userRow.createCell(uCol++);
			dataCell.setCellValue(user.getUserId());
			dataCell.setCellStyle(dCellStyle);

			dataCell = userRow.createCell(uCol++);
			dataCell.setCellValue(user.getUsername());
			dataCell.setCellStyle(dCellStyle);

			dataCell = userRow.createCell(uCol++);
			dataCell.setCellValue(user.getPassword());
			dataCell.setCellStyle(dCellStyle);

		}

		OutputStream outputStream = new FileOutputStream(new File("D:\\user.xls"));
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();

		return "redirect:/back/userList";

	}
	
	//报表打印
		@RequestMapping("printFilm")
		public String printFilm() throws IOException{
			
			//准备打印数据
			List<Film> filmList = filmService.findAll();
			
			/**
			 * 1.创建工作空间
			 * 2.创建工作簿
			 * 3.创建行
			 * 4.创建单元格
			 * 
			 */
			Workbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet("用户信息表");
			//设定列宽
			for(int i=0;i<12;i++){
				sheet.setColumnWidth(i, 13*256);
			}
			
			sheet.setColumnWidth(11, 40*256);
			
			Row titleRow = sheet.createRow(0);	//创建标题行
			titleRow.setHeightInPoints(48);;		//设定行高为48
			
			Cell cell = titleRow.createCell(0);
			cell.setCellValue("影片信息表");
			
			//设置合并单元格  起始行 结束行  起始列 结束列
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
			
			//设定标题样式
			CellStyle titleStyle = workbook.createCellStyle();
			titleStyle.setAlignment(HorizontalAlignment.CENTER); //设定水平居中
			titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); //设定垂直居中
			
			//设定标题样式
			Font titleFont = workbook.createFont();
			titleFont.setFontName("黑体");
			titleFont.setFontHeightInPoints((short)28);
			titleFont.setBold(true);		//标题元素加粗
			titleStyle.setFont(titleFont);	//将字体格式添加到样式中
			cell.setCellStyle(titleStyle);
			
			//设定副标题
			int subCols = 0; //设定行号
			Row subTitle = sheet.createRow(1);  //创建第二行
			subTitle.setHeightInPoints(35);
			String[] clos = {"影片ID","影片名","影片类型ID","影片类型名","影片描述","上映时间","上映状态","电影时长","票价"};
			Font subFont = workbook.createFont();
			subFont.setFontName("黑体");
			subFont.setFontHeightInPoints((short)12);  //字体12号
			subFont.setBold(true);
			CellStyle subStyle = workbook.createCellStyle(); //设定单元格字体
			subStyle.setFont(subFont);
			subStyle.setAlignment(HorizontalAlignment.CENTER);  //左右居中
			subStyle.setVerticalAlignment(VerticalAlignment.CENTER); //上下居中
			subStyle.setBorderBottom(BorderStyle.THIN);  //下细线
			subStyle.setBorderTop(BorderStyle.THIN);     //上细线
			subStyle.setBorderLeft(BorderStyle.THIN);    //左细线
			subStyle.setBorderRight(BorderStyle.THIN);   //右细线
			
			for (String titleName : clos) {
				Cell subCell = subTitle.createCell(subCols++);   //循环新增行
				subCell.setCellValue(titleName);
				subCell.setCellStyle(subStyle);
			}
			
			
			//定义打印数据
			
			int uRow = 2;   //表示第三行
			CellStyle dCellStyle = workbook.createCellStyle();
			dCellStyle = StyleUtil.borderThinAndCenter(dCellStyle);
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			for (Film film : filmList) {
				int uCol = 0;
				Row userRow = sheet.createRow(uRow++); //行自增   一行12列
				Cell dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getFilmId());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getFilmName());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getType().getTypeId());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getType().getTypeName());
				dataCell.setCellStyle(dCellStyle);
				
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getDescribes());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(fmt.format(film.getReleaseDate()));
				
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getState());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getDuration());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(film.getPrice());
				dataCell.setCellStyle(dCellStyle);
			}
			
			
			
			OutputStream outputStream = new FileOutputStream(new File("D:\\film.xls"));
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
			
			return "redirect:/back/filmlist";
			
		}
		@RequestMapping("printOrder")
		public String printOrder() throws IOException{
			
			//准备打印数据
			List<Order> orderList = orderService.findAll();
			
			/**
			 * 1.创建工作空间
			 * 2.创建工作簿
			 * 3.创建行
			 * 4.创建单元格
			 * 
			 */
			Workbook workbook = new HSSFWorkbook();
			Sheet sheet = workbook.createSheet("订单信息表");
			//设定列宽
			for(int i=0;i<12;i++){
				sheet.setColumnWidth(i, 13*256);
			}
			
			sheet.setColumnWidth(11, 40*256);
			
			Row titleRow = sheet.createRow(0);	//创建标题行
			titleRow.setHeightInPoints(48);;		//设定行高为48
			
			Cell cell = titleRow.createCell(0);
			cell.setCellValue("订单信息表");
			
			//设置合并单元格  起始行 结束行  起始列 结束列
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
			
			//设定标题样式
			CellStyle titleStyle = workbook.createCellStyle();
			titleStyle.setAlignment(HorizontalAlignment.CENTER); //设定水平居中
			titleStyle.setVerticalAlignment(VerticalAlignment.CENTER); //设定垂直居中
			
			//设定标题样式
			Font titleFont = workbook.createFont();
			titleFont.setFontName("黑体");
			titleFont.setFontHeightInPoints((short)28);
			titleFont.setBold(true);		//标题元素加粗
			titleStyle.setFont(titleFont);	//将字体格式添加到样式中
			cell.setCellStyle(titleStyle);
			
			//设定副标题
			int subCols = 0; //设定行号
			Row subTitle = sheet.createRow(1);  //创建第二行
			subTitle.setHeightInPoints(35);
			String[] clos = {"订单ID","顾客名","电影名","开始时间","票价","影厅号","座位号"};
			Font subFont = workbook.createFont();
			subFont.setFontName("黑体");
			subFont.setFontHeightInPoints((short)12);  //字体12号
			subFont.setBold(true);
			CellStyle subStyle = workbook.createCellStyle(); //设定单元格字体
			subStyle.setFont(subFont);
			subStyle.setAlignment(HorizontalAlignment.CENTER);  //左右居中
			subStyle.setVerticalAlignment(VerticalAlignment.CENTER); //上下居中
			subStyle.setBorderBottom(BorderStyle.THIN);  //下细线
			subStyle.setBorderTop(BorderStyle.THIN);     //上细线
			subStyle.setBorderLeft(BorderStyle.THIN);    //左细线
			subStyle.setBorderRight(BorderStyle.THIN);   //右细线
			
			for (String titleName : clos) {
				Cell subCell = subTitle.createCell(subCols++);   //循环新增行
				subCell.setCellValue(titleName);
				subCell.setCellStyle(subStyle);
			}
			
			
			//定义打印数据
			
			int uRow = 2;   //表示第三行
			CellStyle dCellStyle = workbook.createCellStyle();
			dCellStyle = StyleUtil.borderThinAndCenter(dCellStyle);
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
			for (Order order : orderList) {
				int uCol = 0;
				Row userRow = sheet.createRow(uRow++); //行自增   一行12列
				Cell dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(order.getOrderId());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(order.getUser().getUsername());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(order.getSeat().getPlay().getFilm().getFilmName());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(fmt.format(order.getSeat().getPlay().getStartTime()));
				dataCell.setCellStyle(dCellStyle);
				
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(order.getSeat().getPlay().getFilm().getPrice());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(order.getSeat().getPlay().getHall().getHallId());
				dataCell.setCellStyle(dCellStyle);
				
				dataCell = userRow.createCell(uCol++);
				dataCell.setCellValue(order.getSeat().getRow()+"行"+order.getSeat().getCol()+"列");
				dataCell.setCellStyle(dCellStyle);
				
			}
			
			
			
			OutputStream outputStream = new FileOutputStream(new File("D:\\order.xls"));
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
			
			return "redirect:/back/orderList";
			
		}
}

