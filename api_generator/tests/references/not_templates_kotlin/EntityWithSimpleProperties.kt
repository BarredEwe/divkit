// Generated code. Do not modify.

package com.yandex.div2

import android.graphics.Color
import android.net.Uri
import androidx.annotation.ColorInt
import com.yandex.div.json.*
import com.yandex.div.json.expressions.Expression
import com.yandex.div.json.expressions.ExpressionsList
import com.yandex.div.json.schema.*
import com.yandex.div.core.annotations.Mockable
import java.io.IOException
import java.util.BitSet
import org.json.JSONObject
import com.yandex.div.data.*
import org.json.JSONArray

@Mockable
class EntityWithSimpleProperties(
    @JvmField final val boolean: Expression<Boolean>? = null,
    @JvmField final val booleanInt: Expression<Boolean>? = null,
    @JvmField final val color: Expression<Int>? = null,
    @JvmField final val double: Expression<Double>? = null,
    @JvmField final val id: Long = ID_DEFAULT_VALUE, // default value: 0
    @JvmField final val integer: Expression<Long> = INTEGER_DEFAULT_VALUE, // default value: 0
    @JvmField final val positiveInteger: Expression<Long>? = null, // constraint: number > 0
    @JvmField final val string: Expression<String>? = null,
    @JvmField final val url: Expression<Uri>? = null,
) : JSONSerializable, Hashable {

    private var _hash: Int? = null 

    override fun hash(): Int {
        _hash?.let {
            return it
        }
        val hash = 
            (boolean?.hashCode() ?: 0) +
            (booleanInt?.hashCode() ?: 0) +
            (color?.hashCode() ?: 0) +
            (double?.hashCode() ?: 0) +
            id.hashCode() +
            integer.hashCode() +
            (positiveInteger?.hashCode() ?: 0) +
            (string?.hashCode() ?: 0) +
            (url?.hashCode() ?: 0)
        _hash = hash
        return hash
    }

    override fun writeToJSON(): JSONObject {
        val json = JSONObject()
        json.writeExpression(key = "boolean", value = boolean)
        json.writeExpression(key = "boolean_int", value = booleanInt)
        json.writeExpression(key = "color", value = color, converter = COLOR_INT_TO_STRING)
        json.writeExpression(key = "double", value = double)
        json.write(key = "id", value = id)
        json.writeExpression(key = "integer", value = integer)
        json.writeExpression(key = "positive_integer", value = positiveInteger)
        json.writeExpression(key = "string", value = string)
        json.write(key = "type", value = TYPE)
        json.writeExpression(key = "url", value = url, converter = URI_TO_STRING)
        return json
    }

    fun copy(
        boolean: Expression<Boolean>? = this.boolean,
        booleanInt: Expression<Boolean>? = this.booleanInt,
        color: Expression<Int>? = this.color,
        double: Expression<Double>? = this.double,
        id: Long = this.id,
        integer: Expression<Long> = this.integer,
        positiveInteger: Expression<Long>? = this.positiveInteger,
        string: Expression<String>? = this.string,
        url: Expression<Uri>? = this.url,
    ) = EntityWithSimpleProperties(
        boolean = boolean,
        booleanInt = booleanInt,
        color = color,
        double = double,
        id = id,
        integer = integer,
        positiveInteger = positiveInteger,
        string = string,
        url = url,
    )

    companion object {
        const val TYPE = "entity_with_simple_properties"

        private val ID_DEFAULT_VALUE = 0L
        private val INTEGER_DEFAULT_VALUE = Expression.constant(0L)

        @JvmStatic
        @JvmName("fromJson")
        operator fun invoke(env: ParsingEnvironment, json: JSONObject): EntityWithSimpleProperties {
            val logger = env.logger
            var boolean: Expression<Boolean>? = null
            var booleanInt: Expression<Boolean>? = null
            var color: Expression<Int>? = null
            var double: Expression<Double>? = null
            var id: Long = ID_DEFAULT_VALUE
            var integer: Expression<Long> = INTEGER_DEFAULT_VALUE
            var positiveInteger: Expression<Long>? = null
            var string: Expression<String>? = null
            var url: Expression<Uri>? = null
            for (jsonKey in json.keys()) {
                when (jsonKey) {
                    "boolean" -> boolean = JsonParser.readOptionalExpression(json, "boolean", ANY_TO_BOOLEAN, logger, env, TYPE_HELPER_BOOLEAN)
                    "boolean_int" -> booleanInt = JsonParser.readOptionalExpression(json, "boolean_int", ANY_TO_BOOLEAN, logger, env, TYPE_HELPER_BOOLEAN)
                    "color" -> color = JsonParser.readOptionalExpression(json, "color", STRING_TO_COLOR_INT, logger, env, TYPE_HELPER_COLOR)
                    "double" -> double = JsonParser.readOptionalExpression(json, "double", NUMBER_TO_DOUBLE, logger, env, TYPE_HELPER_DOUBLE)
                    "id" -> id = JsonParser.readOptional(json, "id", NUMBER_TO_INT, logger, env) ?: ID_DEFAULT_VALUE
                    "integer" -> integer = JsonParser.readOptionalExpression(json, "integer", NUMBER_TO_INT, logger, env, INTEGER_DEFAULT_VALUE, TYPE_HELPER_INT) ?: INTEGER_DEFAULT_VALUE
                    "positive_integer" -> positiveInteger = JsonParser.readOptionalExpression(json, "positive_integer", NUMBER_TO_INT, POSITIVE_INTEGER_VALIDATOR, logger, env, TYPE_HELPER_INT)
                    "string" -> string = JsonParser.readOptionalExpression(json, "string", logger, env, TYPE_HELPER_STRING)
                    "url" -> url = JsonParser.readOptionalExpression(json, "url", STRING_TO_URI, logger, env, TYPE_HELPER_URI)
                }
            }
            return EntityWithSimpleProperties(
                boolean = boolean,
                booleanInt = booleanInt,
                color = color,
                double = double,
                id = id,
                integer = integer,
                positiveInteger = positiveInteger,
                string = string,
                url = url
            )
        }

        private val POSITIVE_INTEGER_VALIDATOR = ValueValidator<Long> { it: Long -> it > 0 }

        val CREATOR = { env: ParsingEnvironment, it: JSONObject -> EntityWithSimpleProperties(env, json = it) }
    }

}
