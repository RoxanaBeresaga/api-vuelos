package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.exceptions.ResourceNotFoundException;
import codoacodo.vuelosapi.models.Company;
import codoacodo.vuelosapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public void createCompany(Company company) {

        companyRepository.save(company);
    }
    public List<Company> getAllCompanies() {

        return companyRepository.findAll();
    }

    public Optional<Company> findCompanyById(Long id) {

        return companyRepository.findById(id);
    }

    public void deleteCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("company","id",id));
        companyRepository.deleteById(company.getId());
    }

    public Company update(Company company) {
        companyRepository.save(company);
        return companyRepository.findById(company.getId()).orElse(null);
    }
}