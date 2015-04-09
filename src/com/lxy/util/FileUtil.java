/**  ©2012, NCS (China) CO.LTD.All rights reserved.
 *
 *   Foreign Exchange Clearing System - version 1.2.0
 *
 *   This software is the property of NCS and its licensors and is protected by copyright. 
 *   Any reproduction in whole or in part is strictly prohibited.
 *  
 *   you can use the production compliance with the License. 
 *
 *   You can obtain a copy of the License at
 *
 *   http://www.ncs.com.sg
 *
 *   Unless required by applicable law or agreed to in writing.
 *   Source coding and software can be distributed  by the authorization of NCS,only.
 *   All other related product, document and logos are trademarks or registered trademarks of NCS.
 */
/*
 * Change Revision
 * ---------------
 * Date     		Author    			Remarks
 * 2012-2-4   		xiaoxia  		    initial files
 */
package com.lxy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.lxy.common.constants.FileException;


/**
 * FXCS File Utils
 * <p>
 * Module: FXCS CLEARING
 * 
 * @author xiaoxia
 * @version
 * @see FileUtil
 */
public class FileUtil {

	private static Log log = LogFactory.getLog(FileUtil.class);

	public static final int BUFFER_SIZE = 1024;
	
	public static String getBasePath(HttpServletRequest request){
		String path = request.getContextPath();
		StringBuilder sb = new StringBuilder();
		sb.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
			.append(request.getServerPort()).append(path).append("/");
		return sb.toString();
	}
	
	/**
	 * 文件上传
	 * @param request
	 * @param filePath
	 * @throws IllegalStateException
	 * @throws IOException
	 * @return path
	 */
	public static String uploadFile(HttpServletRequest request,String folderPath,String fileName) throws IllegalStateException, IOException{
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		String path = null;
		String imgPath = FileUtil.getBasePath(request) + "productImages";//图片待入库路径 ，页面通过此路径可以访问图片
		
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest  multiRequest = (MultipartHttpServletRequest)request;
			Iterator<String>  iter = multiRequest.getFileNames();
			while(iter.hasNext()){
				MultipartFile muilFile = multiRequest.getFile((String)iter.next());
				if(muilFile != null){
					String suffix = FileUtil.getSuffixFileName(muilFile.getOriginalFilename());
					path = folderPath + File.separator + fileName + suffix;
					imgPath = imgPath + File.separator + fileName + suffix;
					//判断文件夹是否存在，如果不存在则创建文件夹
					if(!FileUtil.isFileExist(folderPath)){
						FileUtil.createDir(folderPath);
					}
					File file = new File(path);
					muilFile.transferTo(file);
				}
			}
		}
		return imgPath;
	}
	
	
	@RequestMapping("/uploadFile")
	public String upload2(HttpServletRequest request,HttpServletResponse response) 
			throws IllegalStateException, IOException{
		CommonsMultipartResolver multipartResolver  = 
				new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){
			
			MultipartHttpServletRequest  multiRequest = (MultipartHttpServletRequest)request;
			
			Iterator<String>  iter = multiRequest.getFileNames();
			while(iter.hasNext()){
					MultipartFile file = multiRequest.getFile((String)iter.next());
				if(file != null){
					String fileName = "demoUpload" + file.getOriginalFilename();
					String path = "D:/" + fileName;
					
					File localFile = new File(path);
					
					file.transferTo(localFile);
				}
			}
		}
		return "/success";
	}

	/**
	 * writeToFile
	 * 
	 * @param is
	 *            is
	 * @param path
	 *            path
	 * @throws FileException
	 *             FileException
	 */
	public static void writeToFile(InputStream is, String path)
			throws FileException {
		writeToFile(is, path, 0L);
	}

	/**
	 * getFileSize
	 * 
	 * @param f
	 *            f
	 * @return file size
	 * @throws FileException
	 *             FileException
	 */
	public static int getFileSize(File f) throws FileException {
		if (f.exists()) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(f);
				return fis.available();
			} catch (Exception e) {
				// e.printStackTrace();
				log.error(e);
				throw new FileException("cannot get the file ["
						+ f.getAbsolutePath() + "] size.");
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						// e.printStackTrace();
						log.error(e);
					}
				}
			}
		}
		return 0;
	}

	/**
	 * getTotalRows
	 * 
	 * @param fileName
	 *            fileName
	 * @return total rows
	 */
	public static long getTotalRows(String fileName) {
		BufferedReader br = null;
		long totalCount = 0;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					fileName), "utf-8"));
			while ((br.readLine()) != null) {
				totalCount++;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			return 0L;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return totalCount;
	}

	/**
	 * initFile
	 * 
	 * @param path
	 *            path
	 * @return whether success
	 */
	private static boolean initFile(String path) {
		File f = new File(path);
		if (!f.exists()) {
			try {
				return f.createNewFile();
			} catch (IOException e) {
				// e.printStackTrace();
				log.error(e);
				return false;
			}
		} else {
			return true;
		}
	}

	/**
	 * writeToFile
	 * 
	 * @param is
	 *            is
	 * @param path
	 *            path
	 * @param skipSize
	 *            skipSize
	 * @throws FileException
	 *             FileException
	 */
	public static void writeToFile(InputStream is, String path, long skipSize)
			throws FileException {
		log.info("--- write " + path + " begin ---");
		RandomAccessFile outputFile = null;
		try {
			outputFile = new RandomAccessFile(path, "rw");
			if (skipSize > 0) {
				outputFile.seek(skipSize);
			}
			byte[] b = new byte[BUFFER_SIZE];
			int i;
			while ((i = is.read(b)) > 0) {
				outputFile.write(b, 0, i);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			log.error(e);
			throw new FileException("write file " + path + " from byte ["
					+ skipSize + "] failure.");
		} finally {
			if (outputFile != null) {
				try {
					outputFile.close();
				} catch (IOException e) {
					// e.printStackTrace();
					log.error(e);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// e.printStackTrace();
					log.error(e);
				}
			}
			log.info("--- write " + path + " end ---");
		}
	}
	public static void limitSpeedWriteToFile(InputStream is, String path,long waitMS)
			throws FileException {
		log.info("--- write " + path + " begin ---");
		RandomAccessFile outputFile = null;
		try {
			outputFile = new RandomAccessFile(path, "rw");
			byte[] b = new byte[BUFFER_SIZE];
			int i;
			while ((i = is.read(b)) > 0) {
				outputFile.write(b, 0, i);
				Thread.sleep(waitMS);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			log.error(e);
			throw new FileException("write file " + path + " from byte ["
					+ 0 + "] failure.");
		} finally {
			if (outputFile != null) {
				try {
					outputFile.close();
				} catch (IOException e) {
					// e.printStackTrace();
					log.error(e);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// e.printStackTrace();
					log.error(e);
				}
			}
			log.info("--- write " + path + " end ---");
		}
	}
	/**
	 * createFile
	 * 
	 * @param path
	 *            path
	 * @param totalSize
	 *            totalSize
	 * @throws FileException
	 *             FileException
	 */
	public static void createFile(String path, long totalSize)
			throws FileException {
		if (initFile(path)) {
			RandomAccessFile outputFile = null;
			try {
				outputFile = new RandomAccessFile(path, "rw");
				if (totalSize > 0) {
					outputFile.setLength(totalSize);
				}
			} catch (Exception e) {
				// e.printStackTrace();
				log.error(e);
				throw new FileException("cannot create file [" + path + "] of "
						+ totalSize + " bytes.");
			} finally {
				if (outputFile != null) {
					try {
						outputFile.close();
					} catch (IOException e) {
						// e.printStackTrace();
						log.error(e);
					}
				}
			}
		}
	}

	/**
	 * getAllFile
	 * 
	 * @param f
	 *            f
	 * @return all files
	 */
	public static List<File> getAllFile(File f) {
		List<File> list = new ArrayList<File>();
		File[] fs = f.listFiles();
		for (File temp : fs) {
			if (temp.isFile()) {
				list.add(temp);
			} else {
				list.addAll(getAllFile(temp));
			}
		}
		return list;
	}

	/**
	 * getAllFile
	 * 
	 * @param path
	 *            path
	 * @return files
	 */
	public static List<File> getAllFile(String path) {
		return getAllFile(new File(path));
	}

	/**
	 * getGivenFolders
	 * 
	 * @param specifiedFolders
	 *            specifiedFolders
	 * @param path
	 *            path
	 * @return files
	 */
	public static List<File> getGivenFolders(String[] specifiedFolders,
			String path) {
		List<File> folders = new ArrayList<File>(specifiedFolders.length);
		File folder = new File(path);
		getGivenFoldersWalker(folders, specifiedFolders, folder);
		return folders;
	}

	/**
	 * getGivenFoldersWalker
	 * 
	 * @param list
	 *            list
	 * @param specifiedFolders
	 *            specifiedFolders
	 * @param folder
	 *            folder
	 */
	private static void getGivenFoldersWalker(List<File> list,
			String[] specifiedFolders, File folder) {
		if (matched(specifiedFolders, folder.getName())) {
			list.add(folder);
		} else {
			if (folder.isFile()) {
				return;
			}
			File[] folders = folder.listFiles();
			for (File director : folders) {
				if (matched(specifiedFolders, folder.getName())) {
					list.add(director);
				} else {
					getGivenFoldersWalker(list, specifiedFolders, director);
				}
			}
		}
	}

	/**
	 * This method is used to get all files in path by fuzzy file name
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 */

	public static List<File> getFilesFromPathByFileName(String path, String fileName) {
		List<File> files = getAllFile(path);
		List<File> result = new ArrayList<File>();
		for (File file : files) {
			String tempName = file.getName();
			if(tempName.matches(fileName)){
				result.add(file);
			}
		}
		return result;
	}

	/**
	 * matched
	 * 
	 * @param specifiedFolders
	 *            specifiedFolders
	 * @param fileName
	 *            fileName
	 * @return whether matched
	 */
	private static boolean matched(String[] specifiedFolders, String fileName) {
		for (String name : specifiedFolders) {
			if (fileName.equals(name)) {
				return true;
			}

		}
		return false;
	}

	/**
	 * readFile
	 * 
	 * @param is
	 *            is
	 * @param encoding
	 *            encoding
	 * @return file content
	 */
	public static String readFile(InputStream is, String encoding) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(is, encoding));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				sb.append("\n" + temp);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (sb.length() > 0) {
			return sb.substring(1);
		} else {
			return "";
		}
	}

	/**
	 * readFileFromPath
	 * 
	 * @param path
	 *            path
	 * @param encoding
	 *            encoding
	 * @return file content
	 */
	public static String readFileFromPath(String path, String encoding) {
		try {
			return readFile(new FileInputStream(path), encoding);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * readFileFromStream
	 * 
	 * @param path
	 *            path
	 * @param encoding
	 *            encoding
	 * @return file content
	 */
	public static String readFileFromStream(String path, String encoding) {
		return readFile(FileUtil.class.getResourceAsStream(path), encoding);
	}

	/**
	 * createDir
	 * 
	 * @param folderName
	 *            folderName
	 */
	public static void createDir(String folderName) {
		createDir(new File(folderName));
	}

	/**
	 * createDir
	 * 
	 * @param folderName
	 *            folderName
	 */
	public static void createDir(File folderName) {
		if (!folderName.exists() || !folderName.isDirectory()) {
			// createDict(folderName.getParentFile());
			folderName.mkdirs();
		}
	}

	/**
	 * getAllFiles
	 * 
	 * @param absolutePath
	 *            absolutePath
	 * @return files
	 */
	public static List<File> getAllFiles(String absolutePath) {
		File folder = new File(absolutePath);
		List<File> list = new ArrayList<File>();
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isFile()) {
				list.add(file);
			}
		}
		return list;
	}

	/**
	 * buildAllFilesForAppend
	 * 
	 * @param finalFileAbsolutePath
	 *            finalFileAbsolutePath
	 * @param separateFile
	 *            separateFile
	 */
	public static void buildAllFilesForAppend(String finalFileAbsolutePath,
			List<File> separateFile) {
		InputStream is = null;
		byte[] b = new byte[BUFFER_SIZE];
		RandomAccessFile rad = null;
		try {
			rad = new RandomAccessFile(new File(finalFileAbsolutePath), "rw");
			for (File file : separateFile) {
				is = new FileInputStream(file);
				int readedLength = 0;
				for (; (readedLength = is.read(b)) != -1;) {
					if (readedLength < BUFFER_SIZE) {
						rad.write(b, 0, readedLength);
						break;
					}
					rad.write(b);
				}
				is.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				rad.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * copyFile
	 * 
	 * @param fromFile
	 *            fromFile
	 * @param toFile
	 *            toFile
	 */
	public static void copyFile(String fromFile, String toFile) {
		OutputStream os = null;
		InputStream is = null;
		try {
			is = new FileInputStream(fromFile);
			os = new FileOutputStream(toFile);
			byte[] b = new byte[BUFFER_SIZE];
			int readedLength = 0;
			for (; (readedLength = is.read(b)) != -1;) {
				if (readedLength < BUFFER_SIZE) {
					os.write(b, 0, readedLength);
					break;
				}
				os.write(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getSuffixFileName(String fileName){
		String suf = "";
		if(!StringUtils.isNullOrEmpty(fileName) && fileName.contains(".")){
			suf = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		}
		return suf;
	}
	
	public static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i=0; i<children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		} 
		return dir.delete();
	}
	public static boolean isFileExist(String filePath)
	{
		File file = new File(filePath);
		if(!file.exists())
			return false;//文件夹不存在
		
		if(!file.isDirectory())  //文件不存在
			return false;
		return true;
	}
	
	/**
	 * splice file name
	 * @param type
	 * @param date
	 * @param version
	 * @return
	 */
	public static String spliceFileName (String type,Date date,int version,String expansibility){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ndate = sdf.format(date);
		String rv = String.valueOf(version);
		String fileName = type + "_" +ndate + "_V" + rv + expansibility ;
		return fileName;
	}

}
