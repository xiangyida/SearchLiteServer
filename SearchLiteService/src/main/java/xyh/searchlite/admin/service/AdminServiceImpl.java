package xyh.searchlite.admin.service;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import xyh.searchlite.admin.mapper.AdminMapper;
import xyh.searchlite.search.entity.Problem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public void addProblem(MultipartFile file) {
        Workbook workbook;
        try {
            workbook =new XSSFWorkbook(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        List<Problem> list = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        sheet.forEach(row -> {
            Problem problem = new Problem();
            problem.setTitle(row.getCell(1).toString());
            problem.setKnowledgePoint(row.getCell(2).toString());
            problem.setProblemPictureName(row.getCell(3).toString());
            problem.setAnswerPictureName(row.getCell(4).toString());
            problem.setPublisher(row.getCell(5).toString());
            list.add(problem);
        });
        list.remove(0);
        adminMapper.insertProblem(list);

    }
}
