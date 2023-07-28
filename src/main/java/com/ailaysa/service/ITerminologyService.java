package com.ailaysa.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ITerminologyService {

	public List<String> extractTerminology(MultipartFile multipartFile);
}
