package com.example.hui.template.http.engine;

import android.content.Context;

import com.example.hui.template.R;
import com.example.hui.template.common.adapter.CommonAdapter;
import com.example.hui.template.common.adapter.ViewHolder;
import com.example.hui.template.http.engine.mode.TeamListResult;

import java.util.List;

/**
 * Created by hui on 2016/10/11.
 */
public class TeamListTestAdapter extends CommonAdapter<TeamListResult.DataBean.TeamBean>{
    public TeamListTestAdapter(Context context, List<TeamListResult.DataBean.TeamBean> datas) {
        // R.layout.item_team_lv 条目布局
        super(context, datas, R.layout.item_team_lv);
    }

    @Override
    protected void convert(ViewHolder viewHolder, TeamListResult.DataBean.TeamBean teamBean, int position) {
        // R.id.team_skill 代表给这个布局Id的TextView 设置数据
        viewHolder.setText(R.id.team_skill,teamBean.getTeam_skill()).
                setText(R.id.team_location,teamBean.getTeam_location()).
                setText(R.id.team_industry,teamBean.getTeam_industry()).
                setText(R.id.team_worker_nums,teamBean.getTeam_worker_nums()).
                setText(R.id.service_fee,teamBean.getService_fee()).
                setText(R.id.team_name,teamBean.getTeam_name());

        if(teamBean.getIs_account_certification().equals("0")){
            // 未实名
            viewHolder.setImageResource(R.id.account_certification,R.drawable.list_uncertification_icon);
        }else{
            viewHolder.setImageResource(R.id.account_certification,R.drawable.list_certificationed_icon);
        }

        // viewHolder.setImageResource();
        // viewHolder.setImageUrl();
    }
}
