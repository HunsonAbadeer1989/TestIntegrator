package com.integrator.test.office.service;

import com.integrator.test.country.model.mapper.MapperFacade;
import com.integrator.test.office.dao.OfficeDao;
import com.integrator.test.office.model.Office;
import com.integrator.test.office.view.OfficeForSaveView;
import com.integrator.test.office.view.OfficeListInView;
import com.integrator.test.office.view.OfficeListOutView;
import com.integrator.test.office.view.OfficeView;
import com.integrator.test.organization.dao.OrganizationDao;
import com.integrator.test.organization.model.Organization;
import com.integrator.test.organization.service.OrganizationService;
import com.integrator.test.organization.view.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OfficeView getOfficeById(Long id) {
        Office office = officeDao.loadById(id);
        return mapperFacade.map(office, OfficeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OfficeListOutView> getOfficesList(OfficeListInView officeListInView) {
        Organization organizationById = organizationDao.loadById(officeListInView.getOrgId());
        List<Office> offices = officeDao.loadOfficeList(organizationById,
                officeListInView.getName(),
                officeListInView.getPhone(),
                officeListInView.getIsActive());
        return mapperFacade.mapAsList(offices, OfficeListOutView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultEntity updateOffice(Long id, OfficeView officeView) {
        officeDao.updateOffice(id, officeView);
        return new ResultEntity("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultEntity saveOffice(OfficeForSaveView office) {
        Organization organization = organizationDao.loadById(office.getOrgId());
        Office newOffice = new Office(
                office.getName(),
                office.getAddress(),
                office.getPhone(),
                office.getIsActive(),
                organization);

        officeDao.save(newOffice);
        return new ResultEntity("success");
    }
}
