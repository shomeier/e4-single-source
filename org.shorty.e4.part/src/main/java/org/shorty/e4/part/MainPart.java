package org.shorty.e4.part;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class MainPart
{

	private Text text;

	@Inject
	public MainPart(Composite parent)
	{
		Composite composite = new Composite(parent, SWT.NONE);

		// Display display = Display.getCurrent();
		// composite.setBackground(display.getSystemColor(SWT.COLOR_BLUE));

		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		text = new Text(composite, SWT.BORDER);

		Button datumButton = new Button(composite, SWT.NONE);
		datumButton.setText("Datum");
		datumButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				text.setText(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
			}
		});

		Button zeitButton = new Button(composite, SWT.PUSH);
		zeitButton.setText("Zeit");
		zeitButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				text.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		});
	}
}
