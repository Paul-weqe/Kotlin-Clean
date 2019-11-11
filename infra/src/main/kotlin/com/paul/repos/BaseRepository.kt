package com.paul.repos

import com.paul.entity.BaseEntity

@Suppress("UNCHECKED_CAST")
open class BaseRepository<T, I> : IBaseRepository<T, I>{
    val baseMap = mutableMapOf<I, BaseEntity<I>>()

    override fun create(t: BaseEntity<I>): BaseEntity<I> {
        t.id = generateId() as I
        baseMap[t.id!!] = t
        return t
    }

    override fun merge(t: BaseEntity<I>): BaseEntity<I> {
        baseMap[t.id!!] = t
        return t
    }

    override fun findById(id: I): BaseEntity<I>? {
        return when (val item = baseMap[id]){
            null -> null
            else -> item
        }
    }

    override fun findByName(name: String): BaseEntity<Int>? {
        for(item in baseMap){
            if (item.value.name == name) {
                return item.value as BaseEntity<Int>
            }
        }
        return null
    }

    override fun findAll(): ArrayList<BaseEntity<I>> {
        val itemArray = ArrayList<BaseEntity<I>>()
        baseMap.forEach {
            itemArray.add(it.value)
        }
        return itemArray
    }

    override fun generateId(): I? {
        return baseMap.size.plus(1) as I
    }

}