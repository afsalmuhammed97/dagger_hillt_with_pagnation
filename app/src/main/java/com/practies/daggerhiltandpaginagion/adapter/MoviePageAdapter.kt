package com.practies.daggerhiltandpaginagion.adapter

class MoviePageAdapter{}
//PagingDataAdapter<Result, MoviePageAdapter.MyViewHolder>(diffCallback) {
//
//
//inner class MyViewHolder(val binding: RickMortyItemBinding):RecyclerView.ViewHolder(binding.root)
//
//    companion object{
//        val diffCallback=object :DiffUtil.ItemCallback<Result>(){
//            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
//                 return    oldItem.id==newItem.id
//            }
//
//            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
//               return  oldItem==newItem
//            }
//
//        }
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//
//        val currentItem= getItem(position)
//        holder.binding.apply {
//            textView.text = "${currentItem?.title}"
//            val imageLink = currentItem?.poster_path
//
//            Glide.with(holder.itemView.context).load("http://image.tmdb.org/t/p/w500${imageLink}")
//                .apply(RequestOptions.placeholderOf(R.drawable.ic_launcher_background))
//                //.centerCrop()
//
//                .into(holder.binding.imageView)
//        }
//
//           val view=holder.itemView
//                    holder.itemView.setOnClickListener {
//                        val intent=Intent(holder.itemView.context,MovieDetails::class.java)
//
//                        holder.itemView.context.startActivity(intent)
//                    }
//
//
//
//
//
//
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//       return  MyViewHolder(
//           RickMortyItemBinding.inflate(
//               LayoutInflater.from(parent.context),parent,false
//           )
//       )
//    }
//}