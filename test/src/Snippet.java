

public class Snippet {
	public static void main(String[] args) {
		System.err.println(checkWaybillImage("604286124942A"));
	}
	private static  Boolean checkWaybillImage(String fileName ){
			if(!fileName.matches("^([A-Z]|\\d){11,13}[ABCDEP]{1}$")){
				return false;
			}
			return true;
		}
}