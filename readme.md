Fluid Grid for Java FX
=============
Just like TiledPane, but will automagically resize elements to give the appearance of a fluid layout.

Issue with TiledPane: gap on right hand side of pane:

![TiledPane issue](http://i.imgur.com/qMRqqxb.jpg)

Elements are resized with FluidGrid:

![FluidGrid fix](http://i.imgur.com/tDfLajy.jpg)

Examples
-------
Run `test/co.j6mes.ui.fluidgrid.example.UITest'

Quick Start
-------
```java
Pane pane = new MultiObjectPane();
pane.addObject(....);
```

Extensions
-------
Drag and Drop  (co.j6mes.ui.fluidgrid.extension.DragAndDrop)

Single Item Selection (co.j6mes.ui.fluidgrid.extension.Selection)


License
-------
Apache 2.0 [http://www.apache.org/licenses/LICENSE-2.0]