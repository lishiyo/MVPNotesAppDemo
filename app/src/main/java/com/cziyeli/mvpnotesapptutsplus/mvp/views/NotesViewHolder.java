package com.cziyeli.mvpnotesapptutsplus.mvp.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.cziyeli.mvpnotesapptutsplus.R;
import com.cziyeli.mvpnotesapptutsplus.model.Note;

/**
 * Created by connieli on 6/18/16.
 */
public class NotesViewHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.holder_container)
	public RelativeLayout container;

	@BindView(R.id.note_text)
	public TextView text;

	@BindView(R.id.note_date)
	public TextView date;

	@BindView(R.id.btn_delete)
	public ImageButton btnDelete;
	@OnClick(R.id.btn_delete)
	public void clickDeleteNote(final Button button) {

	}

	private Note mNote;

	public NotesViewHolder(View itemView) {
		super(itemView);

		ButterKnife.bind(this, itemView);
	}

	public void bindModel(final Note note) {
		mNote = note;
		text.setText( note.getText() );
		date.setText( note.getDate() );
	}
}
