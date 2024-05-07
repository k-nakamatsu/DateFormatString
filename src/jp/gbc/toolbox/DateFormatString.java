package jp.gbc.toolbox;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class DateFormatString {

	public DateFormatString() {
		super();
	}

	/**
	 * start処理(メイン)
	 * @param 入力ファイル格納パス
	 */
	private void start(String[] args) {
		if (args.length != 1){
			printUsage();
		    System.exit(1);
		}

		String dtformat = args[0];
		if (StringUtils.isEmpty(dtformat)) {
		    System.exit(1);
		}

		Calendar cl = Calendar.getInstance();

		try {
			format(cl, dtformat);
		} catch(Exception e) {
			System.err.println(ExceptionUtils.getStackTrace(e));
		}
	}

	private void format(Calendar cl, String format) {
        //フォーマットを指定する
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println(sdf.format(cl.getTime()));
	}

	/**
	 * printUsage処理<br>
	 * 実行クラス名、version をログに出力
	 */
	private void printUsage() {
		// print usage.
		String jarname = "DateFormatString.jar";
		String jarversion = "1.0.0";
		System.out.println(String.format("Usage: java -jar %s <format>", jarname));
		System.out.println(String.format("%s version \"%s\"\n", jarname, jarversion));
		System.out.println(String.format("  ex. \"'hoge.txt_'yyyyMMddHHmmssSSS\"\n", jarname, jarversion));
	}

	public static void main(String[] args) {
		new DateFormatString().start(args);
		System.exit(0);
	}

}
