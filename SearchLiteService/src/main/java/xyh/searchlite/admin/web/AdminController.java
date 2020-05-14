package xyh.searchlite.admin.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyh.searchlite.admin.service.AdminService;
import xyh.searchlite.common.result.ApiResult;
import xyh.searchlite.common.result.ResultUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/upload")
    public ApiResult<?> uploadProblem(@RequestParam(value = "file") MultipartFile file){
        adminService.addProblem(file);
        return ResultUtil.success();
    }
}
