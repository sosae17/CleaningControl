class BathroomGroupAdapter(
    private val groups: List<BathroomGroup>,
    private val shift: String
) : RecyclerView.Adapter<BathroomGroupAdapter.GroupViewHolder>() {

    class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textGroupName = view.findViewById<TextView>(R.id.textGroupName)
        val recyclerGroupBathrooms = view.findViewById<RecyclerView>(R.id.recyclerGroupBathrooms)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bathroom_group, parent, false)
        return GroupViewHolder(view)
    }

    override fun getItemCount() = groups.size

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = groups[position]

        holder.textGroupName.text = group.groupName

        // Filtrar por turno
        val filtered = group.bathrooms.filter { it.shift == shift }

        holder.recyclerGroupBathrooms.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.recyclerGroupBathrooms.adapter = BathroomAdapter(filtered)
    }
}
