package com.cziyeli.mvpnotesapptutsplus.mvp.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.cziyeli.mvpnotesapptutsplus.R;
import com.cziyeli.mvpnotesapptutsplus.mvp.NotesMVP;
import com.cziyeli.mvpnotesapptutsplus.mvp.NotesPresenter;

/**
 * Simple view layer.
 */
public class MainActivity extends AppCompatActivity implements NotesMVP.View {
	// View stuff
	@BindView(R.id.edit_note)
	private EditText mTextNewNote;

	// Adapter
	private NotesAdapter mNotesAdapter;

	// Presenter acts as api to domain layer
	private NotesPresenter mPresenter;

	@OnClick(R.id.fab)
	public void addNote(View view) {
		// Adds a new note
		mPresenter.clickNewNote(mTextNewNote);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

//		setupViews();
//		setupMVP();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		mPresenter.onDestroy(isChangingConfigurations());
	}

	@Override
	public Context getAppContext() {
		return getApplicationContext();
	}

	@Override
	public Context getActivityContext() {
		return this;
	}

	@Override
	public void notifyDataSetChanged() {
		mNotesAdapter.notifyDataSetChanged();
	}

	@Override
	public void notifyItemInserted(int layoutPosition) {
		mNotesAdapter.notifyItemInserted(layoutPosition);
	}

	@Override
	public void notifyItemRangeChanged(int positionStart, int itemCount) {
		mNotesAdapter.notifyItemRangeChanged(positionStart, itemCount);
	}

	// Adapter is part of the View layer - all it does is display what it's given.
	// All dat,a state, business logic/processing etc lies in the Presenter, not inside this adapter.
	private class NotesAdapter extends RecyclerView.Adapter<NotesViewHolder>
	{
		@Override
		public int getItemCount() {
			return mPresenter.getNotes().size();
		}

		@Override
		public NotesViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
			final View view = LayoutInflater.from(getActivityContext()).inflate(R.layout.list_item_note, parent, false);

			return new NotesViewHolder(view);
		}

		@Override
		public void onBindViewHolder(final NotesViewHolder holder, final int position) {
			// grab the model from the presenter and forward it to the viewholder
			holder.bindModel(mPresenter.getNote(position));
		}
	}
}
