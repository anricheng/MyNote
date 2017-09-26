package com.example.hui.template.http.engine.mode;

import java.util.List;

/**
 * Created by hui on 2016/9/28.
 */
public class TeamListResult {

    private DataBean data;
    /**
     * data : {"list":[{"team_name":"莱芜吕航防腐工程队","team_worker_nums":"6人团队","service_id":"253","service_fee":"200元/人/天","latitude":"36.26128700","longitude":"117.68217100","is_account_certification":"0","team_industry":"建材建筑-钢结构建筑","team_skill":"防腐-喷砂","team_location":"山东省-莱芜市-莱城区"},{"team_name":"永兴防腐保温","team_worker_nums":"5人团队","service_id":"251","service_fee":"300元/人/天","latitude":"35.27092100","longitude":"114.93793500","is_account_certification":"1","team_industry":"石油化工-油气设备","team_skill":"防腐-机械除锈","team_location":"河南省-新乡市-长垣县"},{"team_name":"王子俊防腐保温工程队","team_worker_nums":"8人团队","service_id":"246","service_fee":"200元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"电力-火电","team_skill":"防腐-喷砂","team_location":""},{"team_name":"白石施工队","team_worker_nums":"12人团队","service_id":"245","service_fee":"200元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"建材建筑-钢结构建筑","team_skill":"保温保冷-架子工","team_location":""},{"team_name":"闫集防腐保温队","team_worker_nums":"5人团队","service_id":"244","service_fee":"220元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"建材建筑-钢结构建筑","team_skill":"保温保冷-保温衬里","team_location":""},{"team_name":"陈志雄防腐保温","team_worker_nums":"12人团队","service_id":"243","service_fee":"250元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"电力-火电","team_skill":"保温保冷-包棉","team_location":""},{"team_name":"卓越先锋队","team_worker_nums":"9人团队","service_id":"242","service_fee":"200元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"电力-火电","team_skill":"防腐-喷砂","team_location":""},{"team_name":"廖正新保温防腐施工","team_worker_nums":"10人团队","service_id":"241","service_fee":"300元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"电力-火电","team_skill":"防腐-机械除锈","team_location":""},{"team_name":"廖正新保温防腐施工","team_worker_nums":"10人团队","service_id":"240","service_fee":"300元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"冶金-钢铁工业","team_skill":"防腐-机械除锈","team_location":""},{"team_name":"防腐安装有限公司","team_worker_nums":"6人团队","service_id":"239","service_fee":"220元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"石油化工-油气输送管道","team_skill":"保温保冷-保温衬里","team_location":""},{"team_name":"长垣精英队","team_worker_nums":"11人团队","service_id":"238","service_fee":"200元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"建材建筑-钢结构建筑","team_skill":"防腐-涂装","team_location":""},{"team_name":"马志明保温防腐","team_worker_nums":"11人团队","service_id":"237","service_fee":"180元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"电力-火电","team_skill":"保温保冷-包棉","team_location":""},{"team_name":"夏道保温队","team_worker_nums":"12人团队","service_id":"235","service_fee":"200元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"电力-水电","team_skill":"保温保冷-保温浇注","team_location":""},{"team_name":"湘潭外护安装队","team_worker_nums":"10人团队","service_id":"234","service_fee":"200元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"电力-火电","team_skill":"保温保冷-外护","team_location":""},{"team_name":"南平曾惠明保温队","team_worker_nums":"9人团队","service_id":"232","service_fee":"200元/人/天","latitude":"0.00000000","longitude":"0.00000000","is_account_certification":"0","team_industry":"建材建筑-建材水泥","team_skill":"保温保冷-保温衬里","team_location":""}]}
     * errcode : 1
     * errmsg : 操作成功
     * errdialog : 0
     */

    private int errcode;
    private String errmsg;
    private int errdialog;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrdialog() {
        return errdialog;
    }

    public void setErrdialog(int errdialog) {
        this.errdialog = errdialog;
    }

    public static class DataBean {
        /**
         * team_name : 莱芜吕航防腐工程队
         * team_worker_nums : 6人团队
         * service_id : 253
         * service_fee : 200元/人/天
         * latitude : 36.26128700
         * longitude : 117.68217100
         * is_account_certification : 0
         * team_industry : 建材建筑-钢结构建筑
         * team_skill : 防腐-喷砂
         * team_location : 山东省-莱芜市-莱城区
         */

        private List<TeamBean> list;

        public List<TeamBean> getList() {
            return list;
        }

        public void setList(List<TeamBean> list) {
            this.list = list;
        }

        public static class TeamBean {
            private String team_name;
            private String team_worker_nums;
            private String service_id;
            private String service_fee;
            private String latitude;
            private String longitude;
            private String is_account_certification;
            private String team_industry;
            private String team_skill;
            private String team_location;

            public String getTeam_name() {
                return team_name;
            }

            public void setTeam_name(String team_name) {
                this.team_name = team_name;
            }

            public String getTeam_worker_nums() {
                return team_worker_nums;
            }

            public void setTeam_worker_nums(String team_worker_nums) {
                this.team_worker_nums = team_worker_nums;
            }

            public String getService_id() {
                return service_id;
            }

            public void setService_id(String service_id) {
                this.service_id = service_id;
            }

            public String getService_fee() {
                return service_fee;
            }

            public void setService_fee(String service_fee) {
                this.service_fee = service_fee;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getIs_account_certification() {
                return is_account_certification;
            }

            public void setIs_account_certification(String is_account_certification) {
                this.is_account_certification = is_account_certification;
            }

            public String getTeam_industry() {
                return team_industry;
            }

            public void setTeam_industry(String team_industry) {
                this.team_industry = team_industry;
            }

            public String getTeam_skill() {
                return team_skill;
            }

            public void setTeam_skill(String team_skill) {
                this.team_skill = team_skill;
            }

            public String getTeam_location() {
                return team_location;
            }

            public void setTeam_location(String team_location) {
                this.team_location = team_location;
            }
        }
    }
}
