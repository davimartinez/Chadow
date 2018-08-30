package io.github.shadowcreative.chadow.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import io.github.shadowcreative.shadow.component.JsonCompatibleSerializer
import io.github.shadowcreative.chadow.entity.ECollection
import io.github.shadowcreative.chadow.entity.Entity
import java.lang.reflect.Type

class EntityAdapter<E> : JsonCompatibleSerializer<Entity<*>>(Entity::class.java)
{
    override fun serialize(src: Entity<*>, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement
    {
        return src.toSerialize()
    }

    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): Entity<*>?
    {
        return ECollection.deserialize<E>(json, this.getReference()) as? Entity<*>
    }
}
