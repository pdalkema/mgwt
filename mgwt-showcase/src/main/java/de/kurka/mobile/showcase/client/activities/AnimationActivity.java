/**
 * 29.12.2010
 * created by kurt
 */
package de.kurka.mobile.showcase.client.activities;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import de.kurka.gwt.mobile.dom.client.event.touch.simple.SimpleTouchHandler;
import de.kurka.gwt.mobile.mvp.client.MGWTAbstractActivity;
import de.kurka.gwt.mobile.ui.client.widget.celllist.CellSelectedEvent;
import de.kurka.gwt.mobile.ui.client.widget.celllist.CellSelectedHandler;
import de.kurka.mobile.showcase.client.ClientFactory;
import de.kurka.mobile.showcase.client.places.AnimationDissolvePlace;
import de.kurka.mobile.showcase.client.places.AnimationFadePlace;
import de.kurka.mobile.showcase.client.places.AnimationFlipPlace;
import de.kurka.mobile.showcase.client.places.AnimationPopPlace;
import de.kurka.mobile.showcase.client.places.AnimationSlidePlace;
import de.kurka.mobile.showcase.client.places.AnimationSlideUpPlace;
import de.kurka.mobile.showcase.client.places.AnimationSwapPlace;
import de.kurka.mobile.showcase.client.places.HomePlace;

/**
 * @author kurt
 *
 */
public class AnimationActivity extends MGWTAbstractActivity {

	private final ClientFactory clientFactory;

	/**
	 * 
	 */
	public AnimationActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		AnimationView view = clientFactory.getAnimationView();

		view.setLeftButtonText("Home");
		view.setTitle("Animation");

		view.setAnimations(createAnimations());

		addHandlerRegistration(view.getBackButton().addSimpleTouchHandler(new SimpleTouchHandler() {

			@Override
			public void onTouch() {
				clientFactory.getPlaceController().goTo(new HomePlace());

			}
		}));

		addHandlerRegistration(view.getCellSelectedHandler().addCellSelectedHandler(new CellSelectedHandler() {

			@Override
			public void onCellSelected(CellSelectedEvent event) {
				int index = event.getIndex();

				switch (index) {
				case 0:
					clientFactory.getPlaceController().goTo(new AnimationSlidePlace());

					break;
				case 1:
					clientFactory.getPlaceController().goTo(new AnimationSlideUpPlace());

					break;
				case 2:
					clientFactory.getPlaceController().goTo(new AnimationDissolvePlace());

					break;
				case 3:
					clientFactory.getPlaceController().goTo(new AnimationFadePlace());

					break;
				case 4:
					clientFactory.getPlaceController().goTo(new AnimationFlipPlace());

					break;
				case 5:
					clientFactory.getPlaceController().goTo(new AnimationPopPlace());

					break;
				case 6:
					clientFactory.getPlaceController().goTo(new AnimationSwapPlace());

					break;

				default:
					break;
				}

			}
		}));

		panel.setWidget(view);

	}

	/**
	 * @return
	 */
	private List<Animation> createAnimations() {
		ArrayList<Animation> list = new ArrayList<Animation>();

		list.add(new Animation("Slide"));
		list.add(new Animation("Slide up"));
		list.add(new Animation("Dissolve"));
		list.add(new Animation("Fade"));
		list.add(new Animation("Flip"));
		list.add(new Animation("Pop"));
		list.add(new Animation("Swap"));

		return list;
	}

}
