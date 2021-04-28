package com.integrator.test.office.service;

import com.integrator.test.country.model.mapper.MapperFacade;
import com.integrator.test.office.dao.OfficeDao;
import com.integrator.test.office.model.Office;
import com.integrator.test.office.view.OfficeForSaveView;
import com.integrator.test.office.view.OfficeListInView;
import com.integrator.test.office.view.OfficeListOutView;
import com.integrator.test.office.view.OfficeView;
import com.integrator.test.organization.dao.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Office> offices = officeDao.loadOfficeList(officeListInView.getOrgId(),
                officeListInView.getName(),
                officeListInView.getPhone(),
                officeListInView.getIsActive());
        return mapperFacade.mapAsList(offices, OfficeListOutView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOffice(Long id, OfficeView officeView) {
        officeDao.updateOffice(id, officeView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveOffice(OfficeForSaveView office) {
        Office saveOffice = mapperFacade.map(office, Office.class);
        officeDao.save(saveOffice, office.getOrgId());
    }
}
