package templates;

import com.tootisabz.CrystalPay.Common.FileHandler;
import com.tootisabz.CrystalPay.Application.Security.AccessControl.RBAC;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer-Token")
@RBAC
public class testController {

    @Autowired
    private final FileHandler fileHandler;


    @Operation(summary = "Upload a file", description = "Upload a file to the server.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File uploaded successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid file uploaded"),
            @ApiResponse(responseCode = "500", description = "File upload failed")
    })
    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a file to upload.");
        }
        return ResponseEntity.ok(fileHandler.FileUpload(file));
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String test(
            @Parameter(description = "File to upload", required = true, content = @Content(schema = @Schema(type = "string", format = "binary")))
            @RequestParam("file") MultipartFile file) {
        return "test";
    }
}
