package com.Quizz.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Quizz.Entity.Questions;
import com.Quizz.Repo.QuestionsRepo;

@Service
public class QuestionsServiceImp implements QuestionsService {
	private QuestionsRepo quesRepo;
	@Autowired
	public QuestionsServiceImp(QuestionsRepo quesRepo) {
		this.quesRepo=quesRepo;
	}
	

	@Override
	public boolean addQuetions(MultipartFile file) throws IOException {

		try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
			// Iterate through each sheet in the workbook
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				// Check for the sheet named "Sheet1"
				if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
					XSSFSheet sheet = workbook.getSheetAt(i);
					System.out.println(sheet.getSheetName() + " found");

					// Get an iterator for all rows in the sheet
					Iterator<Row> rows = sheet.rowIterator();

					// Skip the header row if present
					if (rows.hasNext())
						rows.next();

					// Iterate through all remaining rows
					while (rows.hasNext()) {
						Row row = rows.next();
						Questions que = new Questions();

						// Check for non-empty and numeric cell for questionId
						if (row.getCell(0) != null && row.getCell(0).getCellType() == CellType.NUMERIC) {
							que.setQuestionId((int) row.getCell(0).getNumericCellValue());
						}

						// Check for non-empty and string cell for language
						if (row.getCell(2) != null && row.getCell(2).getCellType() == CellType.STRING) {
							que.setLanguage(row.getCell(2).getStringCellValue());
						}
						if (row.getCell(3) != null && row.getCell(3).getCellType() == CellType.STRING) {
							que.setDifficulty(row.getCell(3).getStringCellValue());
						}

						// Check for non-empty and string cell for question
						if (row.getCell(1) != null && row.getCell(1).getCellType() == CellType.STRING) {
							que.setQuestion(row.getCell(1).getStringCellValue());
						}

						// Process the options from the cell and split into a list
						if (row.getCell(4) != null && row.getCell(4).getCellType() == CellType.STRING) {
							String optionsString = row.getCell(4).getStringCellValue();
							List<String> options = List.of(optionsString.split(", "));
							que.setOptions(options);
						}

						// Check for non-empty and string cell for explanation
						if (row.getCell(5) != null && row.getCell(5).getCellType() == CellType.STRING) {
							que.setExplanation(row.getCell(5).getStringCellValue());
						}

						// Save the question entity to the repository
						quesRepo.save(que);
					}
				}
			}
			// return "Questions added successfully";
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public boolean updateQuestions(Questions que) {

		try {
			Questions q = quesRepo.getByQuestionId(que.getQuestionId());
			q.setDifficulty(que.getDifficulty());
			q.setExplanation(que.getExplanation());
			q.setLanguage(que.getLanguage());
			q.setOptions(que.getOptions());
			q.setQuestion(que.getQuestion());

			quesRepo.save(q);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public boolean deleteQuestions(int questionId) {
		try {
	        quesRepo.deleteByQuestionId(questionId); // Attempt to delete by ID
	        return true; // Return true if deletion was successful
	    } catch (EmptyResultDataAccessException e) {
	        return false; // Return false if the ID was not found
	    }
	}
	@Override
	public boolean addQuetion(Questions que) {
		
		if(quesRepo.save(que) != null) {
			return true;
		}
		return false;
		
		
	}

}
