package com.example.hui.template.adbanner.mode;

import java.util.List;

/**
 * Created by hui on 2016/10/11.
 */
public class CompanyDetailResult {

    /**
     * code : 000000
     * data : {"casePic":{"housesAddress":"202","id":11,"houses":"中央广场","area":"150","ting":"1","style":"现代","wei":"2","name":"现代","mainCut":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203901047.png","shi":"3"},"companyDetail":{"workNum":1,"designerNum":4,"u3dNum":2,"description":"主营室内装修","caseNum":2},"banners":[{"id":13,"banner":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203144710.jpg"},{"id":14,"banner":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203214813.jpg"},{"id":15,"banner":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203231290.jpg"}],"caseNum":2}
     */

    private String code;
    /**
     * casePic : {"housesAddress":"202","id":11,"houses":"中央广场","area":"150","ting":"1","style":"现代","wei":"2","name":"现代","mainCut":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203901047.png","shi":"3"}
     * companyDetail : {"workNum":1,"designerNum":4,"u3dNum":2,"description":"主营室内装修","caseNum":2}
     * banners : [{"id":13,"banner":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203144710.jpg"},{"id":14,"banner":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203214813.jpg"},{"id":15,"banner":"http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203231290.jpg"}]
     * caseNum : 2
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * housesAddress : 202
         * id : 11
         * houses : 中央广场
         * area : 150
         * ting : 1
         * style : 现代
         * wei : 2
         * name : 现代
         * mainCut : http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203901047.png
         * shi : 3
         */

        private CasePicBean casePic;
        /**
         * workNum : 1
         * designerNum : 4
         * u3dNum : 2
         * description : 主营室内装修
         * caseNum : 2
         */

        private CompanyDetailBean companyDetail;
        private int caseNum;
        /**
         * id : 13
         * banner : http://bbjz01.oss-cn-hangzhou.aliyuncs.com/robotImages/2016-09-18/20160918203144710.jpg
         */

        private List<BannersBean> banners;

        public CasePicBean getCasePic() {
            return casePic;
        }

        public void setCasePic(CasePicBean casePic) {
            this.casePic = casePic;
        }

        public CompanyDetailBean getCompanyDetail() {
            return companyDetail;
        }

        public void setCompanyDetail(CompanyDetailBean companyDetail) {
            this.companyDetail = companyDetail;
        }

        public int getCaseNum() {
            return caseNum;
        }

        public void setCaseNum(int caseNum) {
            this.caseNum = caseNum;
        }

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class CasePicBean {
            private String housesAddress;
            private int id;
            private String houses;
            private String area;
            private String ting;
            private String style;
            private String wei;
            private String name;
            private String mainCut;
            private String shi;

            public String getHousesAddress() {
                return housesAddress;
            }

            public void setHousesAddress(String housesAddress) {
                this.housesAddress = housesAddress;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getHouses() {
                return houses;
            }

            public void setHouses(String houses) {
                this.houses = houses;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getTing() {
                return ting;
            }

            public void setTing(String ting) {
                this.ting = ting;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getWei() {
                return wei;
            }

            public void setWei(String wei) {
                this.wei = wei;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMainCut() {
                return mainCut;
            }

            public void setMainCut(String mainCut) {
                this.mainCut = mainCut;
            }

            public String getShi() {
                return shi;
            }

            public void setShi(String shi) {
                this.shi = shi;
            }
        }

        public static class CompanyDetailBean {
            private int workNum;
            private int designerNum;
            private int u3dNum;
            private String description;
            private int caseNum;

            public int getWorkNum() {
                return workNum;
            }

            public void setWorkNum(int workNum) {
                this.workNum = workNum;
            }

            public int getDesignerNum() {
                return designerNum;
            }

            public void setDesignerNum(int designerNum) {
                this.designerNum = designerNum;
            }

            public int getU3dNum() {
                return u3dNum;
            }

            public void setU3dNum(int u3dNum) {
                this.u3dNum = u3dNum;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getCaseNum() {
                return caseNum;
            }

            public void setCaseNum(int caseNum) {
                this.caseNum = caseNum;
            }
        }

        public static class BannersBean {
            private int id;
            private String banner;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBanner() {
                return banner;
            }

            public void setBanner(String banner) {
                this.banner = banner;
            }
        }
    }
}
