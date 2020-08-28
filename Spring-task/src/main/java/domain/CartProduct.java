package domain;

import mbg.model.PmsProduct;
import mbg.model.PmsProductAttribute;
import mbg.model.PmsSkuStock;

import java.util.List;

/**
 * @Description:购物车中选择规格的商品信息
 * @Auther: Yanis_CC
 * @CreateDate: 2020-08-28 16:15
 **/

public class CartProduct extends PmsProduct {
    private List<PmsProductAttribute> productAttributeList;
    private List<PmsSkuStock> skuStockList;

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }


}
