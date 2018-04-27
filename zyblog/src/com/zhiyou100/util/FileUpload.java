package com.zhiyou100.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {

	@SuppressWarnings("unchecked")
	public HttpServletRequest  upload(HttpServletRequest request) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();// 获得磁盘文件条目工厂
		request.setCharacterEncoding("utf-8");
		// 获取服务器下的工程文件中image文件夹的路径
		String path = "D:\\JAVA\\Eclipse\\wrokspace\\zyblog\\WebRoot\\upload";
		// 如果目录不存在则创建
		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		/**
		 * 如果没以下两行设置的话，上传大的 文件 会占用 很多内存， 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同 原理
		 * 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
		 * 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8"); 
		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(request);

			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();		
				//System.out.println(name+"name");
				request.setAttribute(name, "");				
				
				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()){
					// 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					
					String value = new String(item.getString().getBytes("iso-8859-1"),"utf-8");

					request.setAttribute(name, value);
				}
				// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
				else {
					/**
					 *以下三步，主要获取 上传文件的名字
					 */
					String value = item.getName();// 获取路径名
					int start = value.lastIndexOf("/");// 索引到最后一个反斜杠
					String filename2 = value.substring(start + 1);// 截取上传文件的 字符串名字，加1是去掉反斜杠，
					
					String filename = filename2.substring(filename2.lastIndexOf("\\")+1);  
					
					//System.out.println("filename"+filename); 
					
					request.setAttribute(name, filename);
					// 真正写到磁盘上
					OutputStream out = new FileOutputStream(new File(path, filename));
					InputStream in = item.getInputStream();
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("获取上传文件的总共的容量：" + item.getSize() + "文件名为：" + path + "/" + filename);
					// 向数据库中写入文件路径
					request.setAttribute(name, "/image/" + filename);	
					
					String tx="/zyblog/upload/"+filename;
					request.getSession().setAttribute("tx",tx );
					
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);
					}
					in.close();
					out.close();
				}
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return request;

	}

}
