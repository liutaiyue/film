package cn.tarena.film.tool;

public class CheckNull {

	public static boolean checkNull(String ... args){
		boolean flag=true;
		for(int i=0;i<args.length;i++){
			if(args[i].equals("")||args[i]==null){
				return false;
			}
		}
		return flag;
	}
}
