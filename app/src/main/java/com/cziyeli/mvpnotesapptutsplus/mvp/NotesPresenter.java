package com.cziyeli.mvpnotesapptutsplus.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;
import com.cziyeli.mvpnotesapptutsplus.model.Note;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by connieli on 6/18/16.
 */

public class NotesPresenter implements NotesMVP.Presenter.ModelOps<NotesMVP.Model>, NotesMVP.Presenter.ViewOps<NotesMVP.View> {
	// Need a weakref because View can be destroyed at any time
	private WeakReference<NotesMVP.View> mView;
	// Model reference
	private NotesMVP.Model mModel;

	final List<Note> mNotes = new ArrayList<>();

	/**
	 * Presenter Constructor
	 * @param view  MainActivity
	 */
	public NotesPresenter(NotesMVP.View view) {
		mView = new WeakReference<>(view);
	}

	@Override
	public Context getAppContext() {
		return null;
	}

	@Override
	public Context getActivityContext() {
		return null;
	}

	@Override
	public void clickNewNote(EditText editText) {

	}

	@Override
	@NonNull
	public List<Note> getNotes() {
		return mNotes;
	}

	@Override
	@NonNull
	public Note getNote(final int position) {
		return mNotes.get(position);
	}

	@Override
	public void setNotes(List<Note> notes) {

	}

	@Override
	public void onDestroy(boolean isChangingConfiguration) {

	}
	/**
	 * Return the View reference.
	 * Throw an exception if the View is unavailable.
	 */
	private NotesMVP.View getView() throws NullPointerException{
		if ( mView != null )
			return mView.get();
		else
			throw new NullPointerException("View is unavailable");
	}
}
