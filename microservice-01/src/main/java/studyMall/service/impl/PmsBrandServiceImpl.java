package studyMall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import studyMall.mbg.mapper.PmsBrandMapper;
import studyMall.mbg.model.PmsBrand;
import studyMall.mbg.model.PmsBrandExample;
import studyMall.service.PmsBrandService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-17 17:39
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Qualifier("PmsBrandMapper")
    private PmsBrandMapper pmsBrandMapper;
    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
