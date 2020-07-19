package com.bolsadeideas.springboot.app.models.service;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public class UploadFileServiceImple implements IUploadFileService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	private final static String UPLOADS_FOLDERS = "uploads";
	private final static String ROOT_PATHTEST = "/home/orgutierrez/Documentos/uploads";
	

	@Override
	public boolean delete(Object cliente) {
		
		Path rootPath = getPath(cliente);
		File archivo = rootPath.toFile();
		
		if(archivo.exists() && archivo.canRead()) {
			archivo.delete();
		}				
		
		return false;
	}
	
	public Path getPath(Object cliente) {
		Path p4 = FileSystems.getDefault().getPath(ROOT_PATHTEST);
		
		return p4.resolve(((Cliente) cliente).getFoto()).toAbsolutePath();
		 
	}

}
