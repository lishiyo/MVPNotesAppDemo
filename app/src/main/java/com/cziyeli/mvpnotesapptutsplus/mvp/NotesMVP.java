package com.cziyeli.mvpnotesapptutsplus.mvp;

import android.content.Context;
import android.widget.EditText;
import com.cziyeli.mvpnotesapptutsplus.model.Note;

import java.util.List;

/**
 * Interface for Presenter that binds a
 * {@link NotesMVP.Model} to a {@link NotesMVP.View}.
 */
public interface NotesMVP {

	interface Presenter {
		/**
		 * ProvidedPresenterOps: required methods to expose to View
		 * Processes user interactions, fetches data, etc.
		 * View --> Presenter
		 */
		interface ViewOps<V extends NotesMVP.View> {
			void clickNewNote(EditText editText);

			List<Note> getNotes(); // returns count

			Note getNote(int position);
		}

		/**
		 * RequiredPresenterOps: required operations to expose to model
		 * Model --> Presenter
		 */
		interface ModelOps<M extends NotesMVP.Model> {
			// TODO: inject these? note these are WeakRefs, hwoever
			Context getAppContext();
			Context getActivityContext();

			void setNotes(List<Note> notes);

			void onDestroy(boolean isChangingConfiguration);
		}

	}

	// ProvidedModelOps: Model must implement these methods
	// Presenter --> Model

	/**
	 * ProvidedModelOps: Model must implement these methods
	 * Presenter --> Model
	 */
	interface Model {
		int getNotesCount();

		Note getNote(int position);

		int insertNote(Note note);

		boolean loadData();
	}

	/**
	 * RequiredViewOps: View must implement these methods
	 * Presenter --> View
	 */
	interface View {
		// TODO: inject these
		Context getAppContext();
		Context getActivityContext();

		// Presenter notifies the View adapter - View itself doesn't hold onto a list of items.
		void notifyDataSetChanged();
		void notifyItemInserted(int layoutPosition);
		void notifyItemRangeChanged(int positionStart, int itemCount);
	}

}
