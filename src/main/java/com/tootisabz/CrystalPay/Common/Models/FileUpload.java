package com.tootisabz.CrystalPay.Common.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class FileUpload {

    public String name;
    public String description;
    public MultipartFile file;

}
