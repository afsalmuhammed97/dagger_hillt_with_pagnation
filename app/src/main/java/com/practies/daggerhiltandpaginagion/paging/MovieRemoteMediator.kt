package com.practies.daggerhiltandpaginagion.paging


class MovieRemoteMediator(){}
//    private val movieDao: MovieDao,
//    private val apiService: ApiService,
//    private val intialPage:Int=1
//):RemoteMediator<Int,Result>() {
//
//
//    override suspend fun load(loadType: LoadType, state: PagingState<Int, Result>)
//    : MediatorResult {
//
//       return try {
//            val page=when(loadType){
//
//                LoadType.PREPEND -> {
//                    val remoteKey=getLastKey(state)?: throw InvalidObjectException("No more page for load")
//               remoteKey.nextKey?:return MediatorResult.Success(endOfPaginationReached = true)
//                }
//                LoadType.APPEND ->{
//                    return  MediatorResult.Success(endOfPaginationReached = true)
//                }
//                LoadType.REFRESH->{
//                    val remoteKey=getClosestKey(state)
//                    remoteKey?.nextKey?.minus(1)?:intialPage
//                }
//
//            }
//
//            val response=apiService.getUpComingMovies(page)     //total_pages   //
//            val endOfPagination=response.body()?.total_pages!!<state.config.pageSize
//
//            if (response.isSuccessful){
//                response.body()?.let {
//                    if (loadType==LoadType.REFRESH){
//                        movieDao.deleteAllMovies()
//                        movieDao.deleteRemoteKeys()
//                    }
//                    val preKey=if (page==intialPage) null else page-1
//                    val nexKey=if (endOfPagination)  null else page+1
//
//                val list=    response.body()?.results?.map {
//                        MovieRemoteKey(it.title,preKey,nexKey)
//                    }
//
//
//                        movieDao.insertMovies(it.results)
//
//
//                    if (list != null) {
//                        movieDao.insertAllRemoteKeys(list)
//                    }
//                }
//                MediatorResult.Success(endOfPagination)
//            }
//           else{ MediatorResult.Success(endOfPaginationReached = true) }
//
//
//
//        }catch (e:Exception){
//            MediatorResult.Error(e)
//        }
//
//
//    }
//
//    suspend fun getClosestKey(state: PagingState<Int, Result>): MovieRemoteKey? {
//      return  state.anchorPosition?.let {
//            state.closestItemToPosition(it)?.let {
//                movieDao.getAllRemoteKeys(it.title)
//            }
//        }
//    }
//
//
//    suspend fun  getLastKey(state: PagingState<Int, Result>):MovieRemoteKey?{
//        return  state.lastItemOrNull()?.let {
//            movieDao.getAllRemoteKeys(it.title)
//        }
//    }
//}