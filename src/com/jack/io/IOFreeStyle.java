package com.jack.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * IO操作
 * @author lzj
 *	@version 2020-07-29
 */
public class IOFreeStyle {
	
	private volatile static IOFreeStyle ioFreeStyle;
	
	private IOFreeStyle() {}
	
	
	
	/**
	 * IO字符流文件读取功能
	 * @param fileName 文件的路径
	 * @param strType 筛选条件:用于读取包含该变量的行数据,如果不需要筛选的话，就填写null或者""
	 * @return 返回读取到的数据集合
	 */
	public List<String> read(String fileName,String strType) throws Exception {
		List<String> list = new ArrayList<>();
		Reader reader = new FileReader(new File(fileName));
		BufferedReader bf = new BufferedReader(reader);
		String log;
		//循环到获取不到数据为止
		while((log = bf.readLine()) != null) {
			if(!(strType.equals(null) && strType.equals(""))) {
				if(log.contains(strType)) {
					list.add(log);
				}
			}else {
				list.add(log);
			}
		}
		bf.close();
		reader.close();
		return list;
	}
	
	
	/**
	 * 字符流写入功能
	 * @param list 需要写入的数据集合
	 * @param path 写入的路径及文件名称
	 */
	public void write(List<String> list,String path) throws Exception {
		Writer writer = new FileWriter(new File(path));
		BufferedWriter bw = new BufferedWriter(writer);
		for(String string : list) {
			bw.write(string);
			bw.newLine();
		}
		bw.close();
		writer.close();
	}
	
	
	public static class IOFreeStyleFactory{
		
		public static IOFreeStyle getInstance() {
			synchronized(IOFreeStyle.class) {
				if(ioFreeStyle != null) {
					return ioFreeStyle;
				}else {
					ioFreeStyle = new IOFreeStyle();
					return ioFreeStyle;
				}
			}
		}
		
	}
	
	
	
}
