package com.codeboss.ecommercelaravelkotlin.data.repository

import com.codeboss.ecommercelaravelkotlin.data.dataSource.local.AuthLocalDataStore
import com.codeboss.ecommercelaravelkotlin.data.dataSource.remote.AuthRemoteDataSource
import com.codeboss.ecommercelaravelkotlin.domain.model.AuthResponse
import com.codeboss.ecommercelaravelkotlin.domain.model.ErrorResponse
import com.codeboss.ecommercelaravelkotlin.domain.model.User
import com.codeboss.ecommercelaravelkotlin.domain.repository.AuthRepository
import com.codeboss.ecommercelaravelkotlin.domain.util.ConvertErrorBody
import com.codeboss.ecommercelaravelkotlin.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataStore: AuthLocalDataStore
): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse>{

        return try {
            val result = authRemoteDataSource.login(email, password)
            //Log.d("AuthRepositoryImpl", "Error: " + result.body()!!)
            if (result.isSuccessful){
                Resource.Success(result.body()!!)
            }else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }
        }
        catch (e: HttpException){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la petición HTTP")
        }
        catch (e: IOException){
            e.printStackTrace()
            Resource.Failure("Verifica tu conexión a Internet")
        }
        catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }

    override suspend fun register(user: User): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.register(user)
            if (result.isSuccessful){
                Resource.Success(result.body()!!)
            }else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }
        }
        catch (e: HttpException){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido en la petición HTTP")
        }
        catch (e: IOException){
            e.printStackTrace()
            Resource.Failure("Verifica tu conexión a Internet")
        }
        catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error desconocido")
        }
    }

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataStore.saveSession(authResponse)

    override suspend fun logout() = authLocalDataStore.logout()

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataStore.getSessionData()
}