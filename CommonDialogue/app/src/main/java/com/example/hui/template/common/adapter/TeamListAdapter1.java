package com.example.hui.template.common.adapter;

import android.content.Context;

import com.example.hui.template.R;
import com.example.hui.template.http.engine.mode.TeamListResult;

import java.util.List;

/**
 * Created by hui on 2016/9/28.
 */
public class TeamListAdapter1 extends CommonAdapter<TeamListResult.DataBean.TeamBean>{

    public TeamListAdapter1(Context context, List<TeamListResult.DataBean.TeamBean> datas) {
        super(context, datas,R.layout.item_team_lv);
    }

    @Override
    protected void convert(ViewHolder viewHolder, TeamListResult.DataBean.TeamBean teamBean, int position) {
        viewHolder.setText(R.id.team_skill,teamBean.getTeam_skill())
                .setText(R.id.team_worker_nums, teamBean.getTeam_worker_nums())
                .setText(R.id.service_fee, teamBean.getService_fee());

        // 设置一些奇怪的数据
        /*TextView tv = viewHolder.getView(R.id.service_fee);
        tv.setText(teamBean.getService_fee());*/

        if(teamBean.getIs_account_certification().equals("0")){
            // 未实名
            viewHolder.setImageResource(R.id.account_certification,R.drawable.list_uncertification_icon);
        }else{
            viewHolder.setImageResource(R.id.account_certification,R.drawable.list_certificationed_icon);
        }

    }

    /*@Override
    protected View convertView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getHolder(mContext,convertView,);

        // 根据当前位置获取数据
        TeamListResult.DataBean.TeamBean teamBean = mDatas.get(position);
        // 设置数据
        // viewHolder.teamSkill.setText(teamBean.getTeam_skill());

        viewHolder.setText(R.id.team_skill,teamBean.getTeam_skill());
        viewHolder.setText(R.id.team_worker_nums,teamBean.getTeam_worker_nums());
        viewHolder.setText(R.id.service_fee,teamBean.getService_fee());

        return viewHolder.getConvertView();

        // 根据数据创建界面
        *//*ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_team_lv,null);

            viewHolder = new ViewHolder();
            viewHolder.accountCertification = (ImageView) convertView.findViewById(R.id.account_certification);
            viewHolder.teamSkill = (TextView) convertView.findViewById(R.id.team_skill);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        // 根据当前位置获取数据
        TeamListResult.DataBean.TeamBean teamBean = mDatas.get(position);
        // 设置数据
        viewHolder.teamSkill.setText(teamBean.getTeam_skill());
        if(teamBean.getIs_account_certification().equals("0")){
            // 未实名
            viewHolder.accountCertification.setImageResource(R.drawable.list_uncertification_icon);
        }else{
            viewHolder.accountCertification.setImageResource(R.drawable.list_certificationed_icon);
        }

        return convertView;*//*
    }


    *//*private static class ViewHolder{
        public TextView teamSkill;
        public ImageView accountCertification;
        // ...
    }*/
}
