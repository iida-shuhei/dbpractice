package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class ReviewRegisterForm {

	// Review
	private Integer shopId;
	private Integer userId;
	@NotBlank(message = "ラーメン名を入力してください")
	private String ramenName;
	@NotBlank(message = "価格を入力してください")
	private String ramenPrice;
	private Integer ramenImagePathId;

	// RamenImage
	@NotNull(message = "画像を選択してください")
	private MultipartFile ramenImage;

}
