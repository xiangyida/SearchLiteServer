package xyh.searchlite.admin.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface AdminService {

    void addProblem(MultipartFile file);
}
