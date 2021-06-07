package com.example.wish2eat.account.presentaion.register

import com.example.wish2eat.R
import com.example.wish2eat.common.core.localApi.InvalidAccountFields
import com.example.wish2eat.common.core.localApi.UserAlreadyExistException
import com.example.wish2eat.common.core.vo.UserVO
import com.example.wish2eat.common.core.webApi.WebRepositoryContract
import io.reactivex.disposables.CompositeDisposable

class RegisterPresenter(
    private val view: RegisterContract.View?,
    private val repository: WebRepositoryContract,
    private val disposable: CompositeDisposable = CompositeDisposable()
) : RegisterContract.Presenter {
    override fun onRegisterAccountButtonClicked(vo: UserVO) {
        try {
            view?.showLoader()

            request(repository.createUser(vo), callback = { text -> view?.showToast(text) })
                .doOnNext {
                    view?.showToast(R.string.user_created)
                }
                .doOnError { error:Throwable -> view?.showToast(error.toString()) }
                .doOnTerminate{ view?.hideLoader() }
                .subscribe().also { disposable.addAll(it) }
        } catch (e: UserAlreadyExistException) {
            view?.showToast(R.string.user_already_exist)
        } catch (e: InvalidAccountFields) {
            view?.showToast(R.string.user_fields_invalid)
        }
    }
}