/*
 * Copyright (C) 2015-2016 Willi Ye <williye97@gmail.com>
 *
 * This file is part of Kernel Adiutor.
 *
 * Kernel Adiutor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Kernel Adiutor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Kernel Adiutor.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.jdcteam.mtweaks.views.recyclerview.downloads;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.jdcteam.mtweaks.R;
import com.jdcteam.mtweaks.utils.Utils;
import com.jdcteam.mtweaks.utils.tools.SupportedDownloads;
import com.jdcteam.mtweaks.views.recyclerview.RecyclerViewItem;

/**
 * Created by willi on 07.07.16.
 */
public class DownloadAboutView extends RecyclerViewItem {

    private final SupportedDownloads.KernelContent mKernelContent;

    public DownloadAboutView(SupportedDownloads.KernelContent kernelContent) {
        mKernelContent = kernelContent;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.rv_download_about_view;
    }

    @Override
    public void onCreateView(View view) {
        super.onCreateView(view);


        TextView shortDescription = view.findViewById(R.id.short_description);
        TextView longDescription = view.findViewById(R.id.long_description);

        shortDescription.setText(Utils.htmlFrom(mKernelContent.getShortDescription()));
        longDescription.setText(Utils.htmlFrom(mKernelContent.getLongDescription()));
        shortDescription.setMovementMethod(LinkMovementMethod.getInstance());
        longDescription.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected boolean cardCompatible() {
        return false;
    }
}
