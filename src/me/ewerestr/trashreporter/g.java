package me.ewerestr.trashreporter;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class g
{
	public g(a w, CommandSender e, String[] r)
	{
		if (e instanceof Player)
		{
			Player c = (Player)e;
			if (c.hasPermission("trashreporter.trash.list"))
			{
				YamlConfiguration f = w._x();
				if (f.getConfigurationSection("R") != null)
				{
					int z = f.getConfigurationSection("R").getKeys(false).size();
					if (z != 0)
					{
						int p = z/5;
						if (z > p*5) p++;
						if (r.length >= 2)
						{
							if (w.s(r[1]))
							{
								if (Integer.parseInt(r[1]) > 1)
								{
									if (Integer.parseInt(r[1]) <= p)
									{
										int i = (Integer.parseInt(r[1])-1)*5;
										int a = Integer.parseInt(r[1])*5;
										if (z < a) a = z;
										c.sendMessage(w._s(5).replace("%page%",r[1]).replace("%amount%",Integer.toString(p)));
										w._p(c, i, a);
									}
									else c.sendMessage(w._s(6).replace("%amount%",Integer.toString(p)));
								}
								else
								{
									int n = 5;
									if(z < n) n = z;
									c.sendMessage(w._s(5).replace("%page%", "0").replace("%amount%", Integer.toString(p)));
									w._p(c, 0, n);
								}
							}
							else c.sendMessage(w._s(7));
						}
						else
						{
							int g = 5;
							if (z < g) g = z;
							w._p(c, 0, g);
						}
					}
					else c.sendMessage(w._s(11));
				}
				else c.sendMessage(w._s(11));
			}
			else c.sendMessage(w._s(0));
		}
		else e.sendMessage("You have to be a player");
	}
}
