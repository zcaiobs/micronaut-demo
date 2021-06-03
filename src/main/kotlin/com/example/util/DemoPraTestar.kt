package com.example.util

data class DemoPraTestar(
    val id: Long?,
    val name: String,
    val email: String,
    val password: String,
    val date: Array<Int>?
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DemoPraTestar

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (date != null) {
            if (other.date == null) return false
            if (!date.contentEquals(other.date)) return false
        } else if (other.date != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + (date?.contentHashCode() ?: 0)
        return result
    }
}
