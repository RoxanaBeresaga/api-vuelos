package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.exceptions.ResourceNotFoundException;
import codoacodo.vuelosapi.models.Company;
import codoacodo.vuelosapi.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/addCompany")
    public void createCompany(@RequestBody Company company) {

        companyService.createCompany(company);
    }
    @CrossOrigin
    @GetMapping("")
    public List<Company> getAllCompanies() {

        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> findCompanyById(@PathVariable Long id) {
        return companyService.findCompanyById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        try {
            companyService.deleteCompanyById(id);
            return ResponseEntity.ok("Empresa eliminada exitosamente");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró una empresa con el ID proporcionado");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Se produjo un error al eliminar la empresa");
        }
    }

    @PutMapping("/update")
    public Optional<Company> updateFlight(@RequestBody Company company){

        return Optional.ofNullable(companyService.update(company));
    }
}