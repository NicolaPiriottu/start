/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.paging.ui

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.paging.PostUIItem
import com.example.android.codelabs.paging.PostUIItem.Type.*
import com.example.android.codelabs.paging.model.Repo

/**
 * Adapter for the list of repositories.
 */
class ReposAdapter : PagingDataAdapter<PostUIItem,  RecyclerView.ViewHolder>(REPO_COMPARATOR) {


    override fun getItemViewType(position: Int): Int = getItem(position)?.type!!.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  RecyclerView.ViewHolder {
        return when (values()[viewType]){
            HEADER -> {
                HeaderViewHolder(
                    binding = HeaderViewHolder.getLayoutInflated(parent)
                )
            }
            POST -> {
                RepoViewHolder.create(parent)
            }
        }

      //  return RepoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder:  RecyclerView.ViewHolder, position: Int) {
       /* val repoItem = getItem(position)
        if (repoItem != null) {
            holder.bind(repoItem)
        }*/

        when (getItem(position)?.type) {

            HEADER -> {
                (holder as HeaderViewHolder).bind(getItem(position) as PostUIItem.Header)
            }
            POST -> {
                (holder as RepoViewHolder).bind(getItem(position) as PostUIItem.RepoUIItem)
            }
            else ->{}
        }

    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<PostUIItem>() {
            override fun areItemsTheSame(oldItem: PostUIItem, newItem: PostUIItem): Boolean =
                oldItem.type == newItem.type

            override fun areContentsTheSame(oldItem: PostUIItem, newItem: PostUIItem): Boolean =
                oldItem == newItem
        }
    }
}
