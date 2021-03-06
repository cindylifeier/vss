package gov.samhsa.c2s.vss.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueSetUploadDto extends UploadResponseDto implements Serializable  {
    private String  valueSetCatCode;
}
