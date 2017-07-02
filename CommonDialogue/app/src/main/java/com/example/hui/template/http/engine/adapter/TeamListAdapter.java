package com.example.hui.template.http.engine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hui.template.R;
import com.example.hui.template.http.engine.mode.TeamListResult;

import java.util.List;

/**
 * Created by hui on 2016/9/28.
 */
public class TeamListAdapter extends BaseAdapter{
    // 显示的是谁的数据  团队列表TeamBean
    private Context mContext;
    private List<TeamListResult.DataBean.TeamBean> mTeams;

    public TeamListAdapter(Context context,List<TeamListResult.DataBean.TeamBean> teams){
        this.mContext = context;
        this.mTeams = teams;
    }


    @Override
    public int getCount() {
        return mTeams.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 根据数据创建界面
        ViewHolder viewHolder;
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
        TeamListResult.DataBean.TeamBean teamBean = mTeams.get(position);
        // 设置数据
        viewHolder.teamSkill.setText(teamBean.getTeam_skill());
        if(teamBean.getIs_account_certification().equals("0")){
            // 未实名
            viewHolder.accountCertification.setImageResource(R.drawable.list_uncertification_icon);
        }else{
            viewHolder.accountCertification.setImageResource(R.drawable.list_certificationed_icon);
        }

        return convertView;
    }


    private static class ViewHolder{
        public TextView teamSkill;
        public ImageView accountCertification;
        // ...
    }
}
