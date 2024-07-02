package uz.pdp.lesson.demo2.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
    private int id;
    private String originalName;
    private String mimeType;
    private String newName;
    private byte[] fileData;
    private LocalDateTime uploadDate;
}
