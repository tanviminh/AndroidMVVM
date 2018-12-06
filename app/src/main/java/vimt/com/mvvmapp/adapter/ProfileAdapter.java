/*
 * Copyright (c) 2018 Phunware Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package vimt.com.mvvmapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import vimt.com.mvvmapp.App;
import vimt.com.mvvmapp.R;
import vimt.com.mvvmapp.databinding.RowProfileBinding;
import vimt.com.mvvmapp.model.ProfileModel;
import vimt.com.mvvmapp.view.ProfileFragment;

/**
 * Created by Gregory Rasmussen on 7/26/17.
 */
public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {
    private List<ProfileModel> data;
    ProfileFragment.ICallBack iCallBack;

    public ProfileAdapter(List<ProfileModel> items, ProfileFragment.ICallBack iCallBack) {
        this.data = items;
        this.iCallBack = iCallBack;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowProfileBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.row_profile, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ProfileModel profileModel = data.get(position);
        holder.binding.setModel(profileModel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //profileModel.setName("aaaaaaaaaaaaaa");

                //holder.binding.setModel(profileModel);
                iCallBack.remove(profileModel);
                App.getActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, ProfileFragment.newInstance(), ProfileFragment.class.getName())
                        .addToBackStack(ProfileFragment.class.getName())
                        .commitAllowingStateLoss();

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        RowProfileBinding binding;

        public MyViewHolder(RowProfileBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }
    }
}
