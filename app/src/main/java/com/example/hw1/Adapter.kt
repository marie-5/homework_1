package com.example.hw1

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.project.view.*
import kotlinx.android.synthetic.main.skill.view.*

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: List<Typeitem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private class HeadViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        private val tmp = root
        private val image = root.image
        private val tname = root.name
        private val tgrade = root.grade
        private val tgithub = root.Github
        fun Bind(name: String, grade: String, github: String) {
            image.clipToOutline = true
            tname.text = name
            tgrade.text = grade
            tgithub.setOnClickListener {
                val t: Uri = Uri.parse(github)
                val intent = Intent(Intent.ACTION_VIEW, t)
                tmp.context.startActivity(intent)
            }

        }
    }

    private class ProjectViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        private val thead = root.head_project
        private val ttext = root.text_project
        fun Bind(head: String, text: String) {
            thead.text = head
            ttext.text = text
        }
    }

    private class SkillsHeadViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        //фильтр
        fun Bind(c: Boolean) {
            //фильтр
        }
    }

    private class SkillsViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        private val tskill = root.tw_1
        private val ttime = root.tw_2
        fun Bind(skill: String, time: String) {
            tskill.text = skill
            ttime.text = time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> HeadViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.header, parent, false)
            )
            2 -> ProjectViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.project, parent, false)
            )
            3 -> SkillsHeadViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.skills_header, parent, false)
            )
            4 -> SkillsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.skill, parent, false)
            )
            else -> HeadViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.header, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = items.size
    override fun getItemViewType(position: Int): Int = items[position].type
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            1 -> {
                val temp: Userinf = items[position] as Userinf
                (holder as HeadViewHolder).Bind(temp.names, temp.grade, temp.github)
            }
            2 -> {
                val temp: Projectinf = items[position] as Projectinf
                (holder as ProjectViewHolder).Bind(temp.head, temp.text)
            }
            3 -> {
                val temp: Skillhead = items[position] as Skillhead
                (holder as SkillsHeadViewHolder).Bind(temp.c)
            }
            4 -> {
                val temp: Skill = items[position] as Skill
                (holder as SkillsViewHolder).Bind(temp.skill, temp.time)
            }
        }
    }
}