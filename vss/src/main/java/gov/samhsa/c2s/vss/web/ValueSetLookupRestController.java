package gov.samhsa.c2s.vss.web;

import gov.samhsa.c2s.vss.domain.ValueSetCategory;
import gov.samhsa.c2s.vss.service.ValueSetLookupService;
import gov.samhsa.c2s.vss.service.dto.CodedConceptAndCodeSystemOidDto;
import gov.samhsa.c2s.vss.service.dto.ValueSetCategoryDto;
import gov.samhsa.c2s.vss.service.dto.ValueSetCategoryMapDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ValueSetLookupRestController {

    private ValueSetLookupService valueSetLookupService;

    @Autowired
    public ValueSetLookupRestController(ValueSetLookupService valueSetLookupService) {
        this.valueSetLookupService = valueSetLookupService;
    }

    @RequestMapping(value = "/valueSetCategories", method = RequestMethod.GET)
    public List<ValueSetCategoryDto> getValueSetCategories() {
        return valueSetLookupService.getValueSetCategories();
    }

    @RequestMapping(value = "/search/valueSetCategoryMaps", method = RequestMethod.POST)
    public List<ValueSetCategoryMapDto> searchValueSetCategoryMaps(@Valid @RequestBody List<CodedConceptAndCodeSystemOidDto> codedConceptAndCodeSystemOidDtos) {
        return valueSetLookupService.lookupValueSetCategoryMaps(codedConceptAndCodeSystemOidDtos);
    }
}