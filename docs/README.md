# TodoApp Documentation

This directory contains the technical documentation for the TodoApp project.

## Files

### Entity-Relationship Diagram
- **[er-diagram.md](er-diagram.md)** - Complete ER diagram documentation with detailed descriptions
- **[er-diagram.png](er-diagram.png)** - Visual PNG version of the ER diagram (1200x800)
- **[er-diagram-hd.png](er-diagram-hd.png)** - High-resolution PNG version (1920x1080)
- **[er-diagram.mmd](er-diagram.mmd)** - Source Mermaid file for generating diagrams

## Usage

### Viewing the ER Diagram
1. **GitHub/GitLab**: The Mermaid diagram in `er-diagram.md` will render automatically
2. **Local Viewing**: Open the PNG files in any image viewer
3. **Presentations**: Use the high-resolution PNG for presentations and documentation

### Regenerating PNG Files
If you need to update the visual diagrams:

```bash
# Install Mermaid CLI (if not already installed)
npm install -g @mermaid-js/mermaid-cli

# Generate standard resolution PNG
mmdc -i docs/er-diagram.mmd -o docs/er-diagram.png -w 1200 -H 800 -b white

# Generate high-resolution PNG
mmdc -i docs/er-diagram.mmd -o docs/er-diagram-hd.png -w 1920 -H 1080 -b white -s 2
```

### Editing the Diagram
1. Edit the `er-diagram.mmd` file with your changes
2. Regenerate the PNG files using the commands above
3. Update the documentation in `er-diagram.md` if needed

## Diagram Features

The ER diagram includes:
- **5 Main Entities**: todos, notification_schedule, notification_history, user_notification_preferences, user_notification_custom_intervals
- **Relationship Mapping**: Clear visualization of foreign key relationships
- **Field Details**: Data types, constraints, and descriptions
- **Professional Styling**: Clean, readable design suitable for technical documentation