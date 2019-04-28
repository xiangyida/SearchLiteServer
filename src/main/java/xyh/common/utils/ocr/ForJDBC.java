package xyh.common.utils.ocr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ForJDBC {
		private Connection connection=null;
		public Statement statement=null;

	/**
	 * 构造函数
	 * 连接数据库
	 * 数据库名称：test
	 * 设置编码utf8
	 *
	 */
	  	public ForJDBC(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://118.89.21.225:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
				statement=connection.createStatement();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	  	/**
	  	 * 关闭
	  	 */
		public void close(){
			try {
				if(this.statement!=null)
				this.statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(this.connection!=null)
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




		}

