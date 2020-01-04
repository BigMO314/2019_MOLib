package frc.molib;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public final class DashTable {
	private final NetworkTable table;
	public DashTable(String key) { this.table = NetworkTableInstance.getDefault().getTable(key); }
	public final void clear() { for(String key : table.getKeys()) table.delete(key); }

	@SuppressWarnings("unchecked")
	public final class Entry<ValueType> {
		private final NetworkTableEntry entry;

		public Entry(String key) { this(key, null); }
		public Entry(String key, ValueType defaultValue) { 
			this.entry = table.getEntry(key);
			this.set(defaultValue);
		}

		public ValueType get() { return (ValueType) entry.getValue().getValue(); }
		public void set(ValueType value) { entry.setValue(value); }
		public final void delete() { entry.delete(); }
	}
}
